package com.songr.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class application {
    @Autowired
    private AlbumRepository albumRepository ;

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

//        List<Album> albums= albumRepository.findAll();
//        model.addAttribute("albumm", new Album());
       model.addAttribute("albums",albumRepository.findAll());


        return "albums";
    }

    @GetMapping("/addAlbum")
    public String addAlbum(){
        return "addAlbum";
    }

    @PostMapping("/albums")
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public RedirectView postAlbum (@RequestParam(value = "Title") String title,
                                   @RequestParam(value = "Artist") String artist,
                                   @RequestParam(value = "SongCount") int songCount,
                                   @RequestParam(value = "Length") int length,
                                   @RequestParam(value = "URL") String imageUrl
    ){
        Album album = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.findAll((Pageable) album);

        return new RedirectView("/albums");

    }
}
