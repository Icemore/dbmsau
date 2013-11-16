package ru.spbau.mit.dbmsau.pages;

import ru.spbau.mit.dbmsau.Context;
import ru.spbau.mit.dbmsau.pages.exception.PageManagerInitException;

abstract public class PageManager {
    public static final Integer PAGE_SIZE = 4 * 1024;
    protected static final Integer EMPTY_PAGES_LIST_HEAD_PAGE_ID = 0;

    protected Context context;

    public PageManager(Context context) {
        this.context = context;
    }

    public PageManager init() throws PageManagerInitException {
        return this;
    }

    abstract public Page getPageById(Integer id);

    public RecordsPage getRecordPageById(Integer id, Integer length) {
        return new RecordsPage(getPageById(id), length);
    }

    abstract public void savePage(Page page);

    abstract public void freePage(Integer pageId);

    abstract public Page allocatePage();
}
