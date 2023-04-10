package com.example.exercise2.controller;

import com.example.exercise2.dto.SongDto;
import com.example.exercise2.model.Song;
import com.example.exercise2.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("")
    public String showList(Model model,@PageableDefault(page = 0,size = 6) Pageable pageable){
        Iterable<Song> songList=iSongService.findAll(pageable);
        model.addAttribute("songList",songList);
        return "song/list";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songDto",new SongDto());
        return "song/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess","Thêm thành công");
        return "redirect:/song";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Song song=iSongService.findById(id).get();
        SongDto songDto=new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "song/edit";
    }
    @PostMapping("/edit")
    public String edit(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        Song song=new Song();
        BeanUtils.copyProperties(songDto,song);
        iSongService.save(song);
        redirectAttributes.addFlashAttribute("mess","Sửa thành công");
        return "redirect:/song";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id,Model model){
        Song song=iSongService.findById(id).get();
        SongDto songDto=new SongDto();
        BeanUtils.copyProperties(song,songDto); //copy từ song ra songDto
        model.addAttribute("songDto",songDto);
        return "song/view";
    }
    @PostMapping("/delete")
    public String delete(int deleteId,RedirectAttributes redirectAttributes){
        iSongService.remove(deleteId);
        redirectAttributes.addFlashAttribute("mess","Xóa thành công");
        return "redirect:/song";
    }
}
