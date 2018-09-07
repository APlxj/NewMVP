package swallow.com.model_data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import swallow.com.model_data.db.DaoSession;
import swallow.com.model_data.db.UserDao;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
@Entity(
        /*schema：告知GreenDao当前实体属于哪个 schema
        schema active：标记一个实体处于活跃状态，活动实体有更新、删除和刷新方法
        nameInDb：在数据库中使用的别名，默认使用的是实体的类名，
        indexes：定义索引，可以跨越多个列
        createInDb：标记创建数据库表（默认：true）
        generateConstructors 自动创建全参构造方法（同时会生成一个无参构造方法）（默认：true）
        generateGettersSetters 自动生成 getters and setters 方法（默认：true）*/
        active = true,
        nameInDb = "User",
        createInDb = true,
        generateConstructors = true,
        generateGettersSetters = true
)
public class User {
    //身份证号码
    @Property(nameInDb = "IDCardNO")
    @NotNull
    private String iDCardNO;
    //姓名
    @Property(nameInDb = "Name")
    @NotNull
    private String name;
    //性别
    @Property(nameInDb = "Gender")
    private String gender;
    //年龄
    @Property(nameInDb = "Age")
    private int age;
    //名族
    @Property(nameInDb = "Nation")
    private String nation;
    //政治面貌
    @Property(nameInDb = "PoliticsStatus")
    private String politicsStatus;
    //学历
    @Property(nameInDb = "Education")
    private String education;
    //电话:登录账号
    @Property(nameInDb = "Mobile")
    @NotNull
    private String mobile;
    //联系地址
    @Property(nameInDb = "Address")
    private String address;
    //密码
    @Property(nameInDb = "Password")
    @NotNull
    private String password;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 649794304)
    public User(@NotNull String iDCardNO, @NotNull String name, String gender,
                int age, String nation, String politicsStatus, String education,
                @NotNull String mobile, String address, @NotNull String password) {
        this.iDCardNO = iDCardNO;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.nation = nation;
        this.politicsStatus = politicsStatus;
        this.education = education;
        this.mobile = mobile;
        this.address = address;
        this.password = password;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getIDCardNO() {
        return this.iDCardNO;
    }

    public void setIDCardNO(String iDCardNO) {
        this.iDCardNO = iDCardNO;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPoliticsStatus() {
        return this.politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
