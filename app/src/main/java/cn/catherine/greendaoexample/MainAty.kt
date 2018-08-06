package cn.catherine.greendaoexample

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cn.catherine.data.*
import cn.catherine.data.DaoMaster.DevOpenHelper
import kotlinx.android.synthetic.main.aty_main.*
import org.greenrobot.greendao.query.WhereCondition


class MainAty : AppCompatActivity() {
    private lateinit var sqLiteDatabase: SQLiteDatabase
    private lateinit var daoSession: DaoSession
    private lateinit var personDao: PersonDao
    private lateinit var fatherDao: FatherDao
    private lateinit var sonDao: SonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aty_main)
        openDB()
        add.setOnClickListener {
            //            add()
//            queryAll()
            diyQuery()
        }
    }

    private fun openDB() {
        sqLiteDatabase = DevOpenHelper(this, "persons.db", null).writableDatabase//得到可写的一个数据库
        daoSession = DaoMaster(sqLiteDatabase).newSession()
        personDao = daoSession.personDao
        fatherDao = daoSession.fatherDao
        sonDao = daoSession.sonDao
    }

    fun add() {
//        val name = name.text.toString()
//        val age = age.text.toString().toInt()
        var son = Son()
        son.name = "kate"
        son.age = 38

        var father = Father()
        father.hobby = "dancing"
        father.tall = 168

        var fatherId = fatherDao.insert(father)
        son.fatherId = fatherId
        sonDao.insert(son)


    }

    fun delete() {
        sonDao.deleteAll()
        fatherDao.deleteAll()
    }

    private fun queryAll() {
        var fathers = fatherDao.queryBuilder().list()
        var sons = sonDao.queryBuilder().list()
        for (i in fathers.indices) {
            println("=====${fathers[i]}")
        }
        for (i in sons.indices) {
            println("=====${sons[i]}")
        }

    }

    private fun diyQuery() {//原始查询
        val sons = sonDao.queryBuilder().where(
                WhereCondition.StringCondition("FATHER_ID IN " + "(SELECT _ID FROM FATHER WHERE TALL = 168)")
        ).build().list()

        for (i in sons.indices) {
            println("====${sons[i]}")
        }
    }

}
