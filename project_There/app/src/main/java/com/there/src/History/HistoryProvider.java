package com.there.src.History;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryProvider {
    private final HistoryDao historyDao;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public HistoryProvider(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    // 유저의 게시물인지 확인
    /*public int checkUserPostExist(int userIdx, int postIdx) throws BaseExeption, BaseException {
        try {
            return postDao.checkUserPostExist(userIdx, postIdx);
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }*/
}
