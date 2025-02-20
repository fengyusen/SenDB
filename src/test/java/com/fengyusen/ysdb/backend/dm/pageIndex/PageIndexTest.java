package com.fengyusen.ysdb.backend.dm.pageIndex;

import com.fengyusen.ysdb.backend.dm.pageCache.PageCache;
import com.fengyusen.ysdb.backend.dm.pageIndex.PageIndex;
import com.fengyusen.ysdb.backend.dm.pageIndex.PageInfo;
import org.junit.Test;

public class PageIndexTest {
    @Test
    public void testPageIndex() {
        PageIndex pIndex = new PageIndex();
        int threshold = PageCache.PAGE_SIZE / 20;
        for(int i = 0; i < 20; i ++) {
            pIndex.add(i, i*threshold);
            pIndex.add(i, i*threshold);
            pIndex.add(i, i*threshold);
        }

        for(int k = 0; k < 3; k ++) {
            for(int i = 0; i < 19; i ++) {
                PageInfo pi = pIndex.select(i * threshold);
                assert pi != null;
                assert pi.pgno == i+1;
            }
        }
    }
}
