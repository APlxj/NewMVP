package swallow.com.model_data.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import swallow.com.model_data.model.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "User".
*/
public class UserDao extends AbstractDao<User, Void> {

    public static final String TABLENAME = "User";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property IDCardNO = new Property(0, String.class, "iDCardNO", false, "IDCardNO");
        public final static Property Name = new Property(1, String.class, "name", false, "Name");
        public final static Property Gender = new Property(2, String.class, "gender", false, "Gender");
        public final static Property Age = new Property(3, int.class, "age", false, "Age");
        public final static Property Nation = new Property(4, String.class, "nation", false, "Nation");
        public final static Property PoliticsStatus = new Property(5, String.class, "politicsStatus", false, "PoliticsStatus");
        public final static Property Education = new Property(6, String.class, "education", false, "Education");
        public final static Property Mobile = new Property(7, String.class, "mobile", false, "Mobile");
        public final static Property Address = new Property(8, String.class, "address", false, "Address");
        public final static Property Password = new Property(9, String.class, "password", false, "Password");
    }

    private DaoSession daoSession;


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"User\" (" + //
                "\"IDCardNO\" TEXT NOT NULL ," + // 0: iDCardNO
                "\"Name\" TEXT NOT NULL ," + // 1: name
                "\"Gender\" TEXT," + // 2: gender
                "\"Age\" INTEGER NOT NULL ," + // 3: age
                "\"Nation\" TEXT," + // 4: nation
                "\"PoliticsStatus\" TEXT," + // 5: politicsStatus
                "\"Education\" TEXT," + // 6: education
                "\"Mobile\" TEXT NOT NULL ," + // 7: mobile
                "\"Address\" TEXT," + // 8: address
                "\"Password\" TEXT NOT NULL );"); // 9: password
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"User\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getIDCardNO());
        stmt.bindString(2, entity.getName());
 
        String gender = entity.getGender();
        if (gender != null) {
            stmt.bindString(3, gender);
        }
        stmt.bindLong(4, entity.getAge());
 
        String nation = entity.getNation();
        if (nation != null) {
            stmt.bindString(5, nation);
        }
 
        String politicsStatus = entity.getPoliticsStatus();
        if (politicsStatus != null) {
            stmt.bindString(6, politicsStatus);
        }
 
        String education = entity.getEducation();
        if (education != null) {
            stmt.bindString(7, education);
        }
        stmt.bindString(8, entity.getMobile());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(9, address);
        }
        stmt.bindString(10, entity.getPassword());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getIDCardNO());
        stmt.bindString(2, entity.getName());
 
        String gender = entity.getGender();
        if (gender != null) {
            stmt.bindString(3, gender);
        }
        stmt.bindLong(4, entity.getAge());
 
        String nation = entity.getNation();
        if (nation != null) {
            stmt.bindString(5, nation);
        }
 
        String politicsStatus = entity.getPoliticsStatus();
        if (politicsStatus != null) {
            stmt.bindString(6, politicsStatus);
        }
 
        String education = entity.getEducation();
        if (education != null) {
            stmt.bindString(7, education);
        }
        stmt.bindString(8, entity.getMobile());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(9, address);
        }
        stmt.bindString(10, entity.getPassword());
    }

    @Override
    protected final void attachEntity(User entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.getString(offset + 0), // iDCardNO
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // gender
            cursor.getInt(offset + 3), // age
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // nation
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // politicsStatus
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // education
            cursor.getString(offset + 7), // mobile
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // address
            cursor.getString(offset + 9) // password
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setIDCardNO(cursor.getString(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setGender(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAge(cursor.getInt(offset + 3));
        entity.setNation(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPoliticsStatus(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setEducation(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMobile(cursor.getString(offset + 7));
        entity.setAddress(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setPassword(cursor.getString(offset + 9));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(User entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(User entity) {
        return null;
    }

    @Override
    public boolean hasKey(User entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
