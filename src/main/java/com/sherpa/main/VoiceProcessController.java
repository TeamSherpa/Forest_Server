package com.sherpa.main;

import com.sherpa.ai.VoiceInputProcessor;
import com.sherpa.exception.CustomError;
import com.sherpa.network.ResponseUtil;
import com.sherpa.v1.mountain.MountainServiceImpl;
import com.sherpa.v1.news.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class VoiceProcessController {

    @Autowired
    private NewsServiceImpl newsServiceImpl;

    @Autowired
    private MountainServiceImpl mountainServiceImpl;

    @RequestMapping(value = "/sendVoice", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> process(@RequestParam("input") String input) {
        try {
            VoiceInputProcessor processor = new VoiceInputProcessor(input);
            return processor.process(newsServiceImpl, mountainServiceImpl);
        } catch (Exception e) {
            return ResponseUtil.exceptionError(CustomError.VOICE_INPUT_API_ERROR.code, CustomError.VOICE_INPUT_API_ERROR.message);
        }
    }
}
