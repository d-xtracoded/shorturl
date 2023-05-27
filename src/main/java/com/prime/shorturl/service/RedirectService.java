package com.prime.shorturl.service;

import com.prime.shorturl.entity.Redirect;
import com.prime.shorturl.execption.BadRequestExecption;
import com.prime.shorturl.execption.NotFoundExecption;
import com.prime.shorturl.repository.RedirectRepository;
import com.prime.shorturl.request.RedirectCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RedirectService {

    private RedirectRepository redirectRepository;
@Autowired
    public RedirectService(RedirectRepository redirectRepository) {
        this.redirectRepository = redirectRepository;
    }

    public Optional<Redirect> CreateRedirect(RedirectCreationRequest redirectCreationRequest) {
        if (redirectRepository.existsByAlias(redirectCreationRequest.getAlias())) {
            throw  new BadRequestExecption("Alias Already exist");
        }
        System.out.println("Redirect Request" + redirectCreationRequest.toString());
        Redirect redirect = new Redirect(redirectCreationRequest.getAlias(),redirectCreationRequest.getUrl());
        redirectRepository.save(redirect);

        Redirect postSaveRedirect = redirectRepository.save(redirect);

        System.out.println("Redirect" + redirect);
        return Optional.ofNullable(postSaveRedirect);
    }

        public Redirect getredirect(String alias){
          Redirect redirect=  redirectRepository.findByAlias(alias)
                  .orElseThrow(()-> new NotFoundExecption("Alias not Found"));
            return redirect;
        }

}
