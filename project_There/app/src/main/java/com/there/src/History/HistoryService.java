package com.there.src.History;

import com.there.config.BaseException;
import com.there.src.History.model.PostHistoryReq;
import com.there.src.History.model.PostHistoryRes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.there.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class HistoryService {


        final Logger logger = LoggerFactory.getLogger(this.getClass());

        private final HistoryDao historyDao;
        private final HistoryProvider historyProvider;


        @Autowired
        public HistoryService(HistoryDao historyDao, HistoryProvider historyProvider) {
            this.historyDao = historyDao;
            this.historyProvider = historyProvider;

        }

    // !-- ethan
    // 게시물 생성
    public PostHistoryRes createPost(PostHistoryReq postHistoryReq) throws BaseException {

        try{

            // 게시물 DB에서 생성시 게시물 식별자 Dao에서 가져옴
            int postIdx = historyDao.insertPost(postHistoryReq);


            return new PostHistoryRes(postIdx);
        }
        catch (Exception exception) {

            throw new BaseException(DATABASE_ERROR);

        }
    }

}
