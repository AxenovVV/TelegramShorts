package com.axenov.shorts.service;

import com.axenov.shorts.database.LinkEntity;
import com.axenov.shorts.database.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkUnshortener {

    private final LinkRepository linkRepository;

    public LinkUnshortener(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String findOriginalLink(String shortPart) {
        LinkEntity linkEntity = linkRepository.findTopByShortLink(shortPart);
        return linkEntity == null ? null : linkEntity.getFullShortLink();
    }
}
