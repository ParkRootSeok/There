package com.there.src.History;

import com.there.config.BaseException;
import com.there.config.BaseResponseStatus;
import com.there.src.History.model.GetHistoryRes;
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

    // 히스토리 조회
    public GetHistoryRes retrieveHistory(int historyIdx) throws BaseException {
        try {
            GetHistoryRes getHistoryRes = historyDao.selectHisPostInfo(historyIdx);

            return getHistoryRes;
        } catch (Exception exception) {
            System.out.println(exception);
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }

    }

}

