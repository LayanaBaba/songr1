package com.songr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class application {
    @Autowired
    private ApplicationRepository albumRepository ;
    @GetMapping("/hello")
    public String helloWorld(@RequestParam(name="name", required = false, defaultValue = "hello world") String name, Model model) {
        return "helloWorld";
    }

    @GetMapping("/capitalize/hello")
    public String helloWorldCapitalize(){
        return "capitalize";
    }



    @GetMapping("/albums")
    public String getAlbum(Model model){
//        ArrayList<Album> album = new ArrayList<>();
//
//        var album1= new Album("title1","artist1",2,5,"url1");
//        var album2= new Album("title2","artist2",2,5,"url2");
//        var album3= new Album("title3","artist3",2,5,"url3");
//
//       album.add(album1);
//       album.add(album2);
//       album.add(album3);

        List<Album> album= albumRepository.findAll();
       model.addAttribute("album",album);


        return "album";
    }

    @PatchMapping("/albums")
    public String addAlbum (@ModelAttribute Album albums, Model model){
        albumRepository.save(albums);
        List<Album> album= albumRepository.findAll();
        model.addAttribute("result",album);

        return "result";

    }
}
