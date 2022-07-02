package com.there.src.History;

import com.there.config.BaseException;
import com.there.config.BaseResponse;
import com.there.src.History.model.PostHistoryReq;
import com.there.src.History.model.PostHistoryRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historys")    // --ethan 수정!
public class HistoryController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final HistoryProvider historyProvider;
    @Autowired
    private final HistoryService historyService;

    public HistoryController(HistoryProvider historyProvider, HistoryService historyService){
        this.historyProvider = historyProvider;
        this.historyService = historyService;

    }

    /**
     * 히스토리 생성 API
     * [POST] /historys
     *
     * @return BaseResponse<postHistoryRes>
     */

    @ResponseBody
    @PostMapping("")
    public BaseResponse<PostHistoryRes> createPost(@RequestBody PostHistoryReq postHistoryReq) {


        try {

            PostHistoryRes postHistoryRes = historyService.createPost(postHistoryReq);

            return new BaseResponse<>(postHistoryRes);

        } catch (BaseException exception) {
            return new BaseResponse<>((exception.getStatus()));
        }
    }



}