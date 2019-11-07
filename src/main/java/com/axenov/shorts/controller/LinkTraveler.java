package com.axenov.shorts.controller;

import com.axenov.shorts.service.LinkShortener;
import com.axenov.shorts.service.LinkUnshortener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LinkTraveler {

    private final LinkUnshortener linkUnshortener;

    public LinkTraveler(LinkUnshortener linkUnshortener, LinkShortener linkShortener) {
        this.linkUnshortener = linkUnshortener;
    }

    @GetMapping("/{shortLink}")
    public String giveMeOriginal(@PathVariable String shortLink) {
        String originalLink = linkUnshortener.findOriginalLink(shortLink);
        return originalLink.isEmpty() ? "errorPage" : "redirect:" + originalLink;
    }
}
