package com.axenov.shorts.service;

import com.axenov.shorts.database.LinkEntity;
import com.axenov.shorts.database.LinkRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class LinkShortener {

    private final LinkRepository linkRepository;

    public LinkShortener(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String shortAndSaveOriginalLink(String originalLink) {
        LinkEntity newLink = new LinkEntity(originalLink, RandomStringUtils.randomAlphanumeric(7));
        linkRepository.save(newLink);
        return newLink.getFullShortLink();
    }
}
