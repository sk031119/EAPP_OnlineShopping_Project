package com.fp.webuser.service;

import com.fp.webuser.model.WebUser;
import com.fp.webuser.repository.WebUserRepository;
import org.springframework.stereotype.Service;

@Service
public class WebUserService {

    private final WebUserRepository webUserRepository;

    public WebUserService(WebUserRepository webUserRepository) {
        this.webUserRepository = webUserRepository;
    }

    public WebUser saveWebUser(WebUser webUser) {
        return webUserRepository.save(webUser);
    }
}
