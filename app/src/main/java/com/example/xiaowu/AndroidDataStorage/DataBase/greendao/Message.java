package com.example.xiaowu.AndroidDataStorage.DataBase.greendao;


import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.ChannelDao;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.DaoSession;
import com.example.xiaowu.AndroidDataStorage.DataBase.greendao.generate.MessageDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by maxiaowu on 16/8/27.
 */
@Entity(nameInDb = "MessageTable" )
public class Message {
    @Id(autoincrement = true)
    private Long id;
    @Unique
    private int id_server;
    private Long msg_channel_id;
    private String msg_title;
    private int msg_type;
    private long create_time;
    private long dead_time;
    @Property(nameInDb = "ReadedFlag")
    private int is_read;
    private int is_in_list;
    private int notify_type;
    private String popup_url;
    private int is_pop;
    private int is_server_deleted;
    //    private int goto_id;
//    private int detail_id;
    private String popup_bg_color;

    //goto

    private int gotoType;
    private int gotoMode;
    private String gotoParam;

    //detail
    private String detailBtn_text;
    private String detailPics_url;

    @ToOne
    private Channel channel;
    @Generated(hash = 1399578503)
    private transient boolean channel__refreshed;
    /** Used for active entity operations. */
    @Generated(hash = 859287859)
    private transient MessageDao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;



    @Generated(hash = 637306882)
    public Message() {
    }


    @Generated(hash = 1519585565)
    public Message(Long id, int id_server, Long msg_channel_id, String msg_title,
            int msg_type, long create_time, long dead_time, int is_read,
            int is_in_list, int notify_type, String popup_url, int is_pop,
            int is_server_deleted, String popup_bg_color, int gotoType,
            int gotoMode, String gotoParam, String detailBtn_text,
            String detailPics_url) {
        this.id = id;
        this.id_server = id_server;
        this.msg_channel_id = msg_channel_id;
        this.msg_title = msg_title;
        this.msg_type = msg_type;
        this.create_time = create_time;
        this.dead_time = dead_time;
        this.is_read = is_read;
        this.is_in_list = is_in_list;
        this.notify_type = notify_type;
        this.popup_url = popup_url;
        this.is_pop = is_pop;
        this.is_server_deleted = is_server_deleted;
        this.popup_bg_color = popup_bg_color;
        this.gotoType = gotoType;
        this.gotoMode = gotoMode;
        this.gotoParam = gotoParam;
        this.detailBtn_text = detailBtn_text;
        this.detailPics_url = detailPics_url;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetailPics_url() {
        return this.detailPics_url;
    }

    public void setDetailPics_url(String detailPics_url) {
        this.detailPics_url = detailPics_url;
    }

    public String getDetailBtn_text() {
        return this.detailBtn_text;
    }

    public void setDetailBtn_text(String detailBtn_text) {
        this.detailBtn_text = detailBtn_text;
    }

    public String getGotoParam() {
        return this.gotoParam;
    }

    public void setGotoParam(String gotoParam) {
        this.gotoParam = gotoParam;
    }

    public int getGotoMode() {
        return this.gotoMode;
    }

    public void setGotoMode(int gotoMode) {
        this.gotoMode = gotoMode;
    }

    public int getGotoType() {
        return this.gotoType;
    }

    public void setGotoType(int gotoType) {
        this.gotoType = gotoType;
    }

    public String getPopup_bg_color() {
        return this.popup_bg_color;
    }

    public void setPopup_bg_color(String popup_bg_color) {
        this.popup_bg_color = popup_bg_color;
    }

    public int getIs_server_deleted() {
        return this.is_server_deleted;
    }

    public void setIs_server_deleted(int is_server_deleted) {
        this.is_server_deleted = is_server_deleted;
    }

    public int getIs_pop() {
        return this.is_pop;
    }

    public void setIs_pop(int is_pop) {
        this.is_pop = is_pop;
    }

    public String getPopup_url() {
        return this.popup_url;
    }

    public void setPopup_url(String popup_url) {
        this.popup_url = popup_url;
    }

    public int getNotify_type() {
        return this.notify_type;
    }

    public void setNotify_type(int notify_type) {
        this.notify_type = notify_type;
    }

    public int getIs_in_list() {
        return this.is_in_list;
    }

    public void setIs_in_list(int is_in_list) {
        this.is_in_list = is_in_list;
    }

    public int getIs_read() {
        return this.is_read;
    }

    public void setIs_read(int is_read) {
        this.is_read = is_read;
    }

    public long getDead_time() {
        return this.dead_time;
    }

    public void setDead_time(long dead_time) {
        this.dead_time = dead_time;
    }

    public long getCreate_time() {
        return this.create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public int getMsg_type() {
        return this.msg_type;
    }

    public void setMsg_type(int msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_title() {
        return this.msg_title;
    }

    public void setMsg_title(String msg_title) {
        this.msg_title = msg_title;
    }

    public Long getMsg_channel_id() {
        return msg_channel_id;
    }

    public void setMsg_channel_id(Long msg_channel_id) {
        this.msg_channel_id = msg_channel_id;
    }

    public int getId_server() {
        return this.id_server;
    }

    public void setId_server(int id_server) {
        this.id_server = id_server;
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 217952122)
    public void setChannel(Channel channel) {
        synchronized (this) {
            this.channel = channel;
            channel__refreshed = true;
        }
    }


    /** To-one relationship, returned entity is not refreshed and may carry only the PK property. */
    @Generated(hash = 1827076537)
    public Channel peakChannel() {
        return channel;
    }


    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1824558789)
    public Channel getChannel() {
        if (channel != null || !channel__refreshed) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ChannelDao targetDao = daoSession.getChannelDao();
            targetDao.refresh(channel);
            channel__refreshed = true;
        }
        return channel;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 747015224)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMessageDao() : null;
    }


}
