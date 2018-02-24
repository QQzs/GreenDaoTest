package com.zs.example.greendaotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.zs.example.greendaotest.greendao.GreenDaoManager;
import com.zs.example.greendaotest.greendao.Movie;
import com.zs.example.greendaotest.greendao.MovieDao;
import com.zs.example.greendaotest.greendao.User;
import com.zs.example.greendaotest.greendao.UserDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void insert(View view){
//        insertdata();
        insertMoviedata();
    }

    public void save(View view){
//        savedata();
        saveMoviedata();
    }

    public void delete(View view){
        deleteAllNote();
    }

    public void update(View view){
        updatadata();
    }

    public void query(View view){
//        querydata();
        queryMoviedata();
    }

    private void getuserById() {
        User user =getUserDao().load(1l);
        Log.i("My_Log", "结果：" + user.getId() + "," + user.getName() + "," + user.getAge() + "," + user.getIsBoy() + ";");


    }

    private void insertdata() {
        //插入数据
        User insertData = new User(1l, "插入数据", 24, false);
        getUserDao().insertOrReplace(insertData);
    }

    private void savedata() {
        //插入数据
        User insertData = new User(2l, "插入数据", 24, false);
        getUserDao().save(insertData);
    }

    private void updatadata() {
        //更改数据
        List<User> userss = getUserDao().loadAll();
        User user = new User(userss.get(0).getId(), "更改后的数据用户", 22, true);
        getUserDao().update(user);

    }

    private void querydata() {
        //查询数据详细
        List<User> users = getUserDao().loadAll();
        Log.i("My_Log", "当前数量：" + users.size());
        for (int i = 0; i < users.size(); i++) {
            Log.i("My_Log", "结果：" + users.get(i).getId() + "," + users.get(i).getName() + "," + users.get(i).getAge() + "," + users.get(i).getIsBoy() + ";");
        }

    }

    private void querydataBy() {////查询条件
        Query<User> nQuery = getUserDao().queryBuilder()
//                .where(UserDao.Properties.Name.eq("user1"))//.where(UserDao.Properties.Id.notEq(999))
                .orderAsc(UserDao.Properties.Age)//.limit(5)//orderDesc
                .build();
        List<User> users = nQuery.list();
        Log.i("My_Log", "当前数量：" + users.size());
        for (int i = 0; i < users.size(); i++) {
            Log.i("My_Log", "结果：" + users.get(i).getId() + "," + users.get(i).getName() + "," + users.get(i).getAge() + "," + users.get(i).getIsBoy() + ";");
        }

//        QueryBuilder qb = userDao.queryBuilder();
//        qb.where(Properties.FirstName.eq("Joe"),
//                qb.or(Properties.YearOfBirth.gt(1970),
//                        qb.and(Properties.YearOfBirth.eq(1970), Properties.MonthOfBirth.ge(10))));
//        List youngJoes = qb.list();
    }


    /**
     * 根据查询条件,返回数据列表
     * @param where        条件
     * @param params       参数
     * @return             数据列表
     */
    public List<User> queryN(String where, String... params){
        return getUserDao().queryRaw(where, params);
    }

    /**
     * 根据用户信息,插件或修改信息
     * @param user              用户信息
     * @return 插件或修改的用户id
     */
    public long saveN(User user){
        return getUserDao().insertOrReplace(user);
    }

    /**
     * 批量插入或修改用户信息
     * @param list      用户信息列表
     */
    public void saveNLists(final List<User> list){
        if(list == null || list.isEmpty()){
            return;
        }
        getUserDao().getSession().runInTx(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<list.size(); i++){
                    User user = list.get(i);
                    getUserDao().insertOrReplace(user);
                }
            }
        });

    }

    /**
     * 删除所有数据
     */
    public void deleteAllNote(){
        getUserDao().deleteAll();
    }

    /**
     * 根据用户类,删除信息
     * @param user    用户信息类
     */
    public void deleteNote(User user){
        getUserDao().delete(user);
    }

    private void insertMoviedata() {
        //插入数据
        Movie movie = new Movie("你的名字", 2018);
        long res = getMovieDao().insertOrReplace(movie);
        Log.i("My_Log", "res = ：" + res);
//        QueryBuilder qb = getMovieDao().queryBuilder();
//        qb.where(MovieDao.Properties.Name.eq("你的名字2"));
//        List dataList = qb.list();
//        if (dataList != null && dataList.size() > 0){
//            getMovieDao().update(movie);
//            Log.i("My_Log", "update data");
//        }else{
//            getMovieDao().insert(movie);
//            Log.i("My_Log", "insert data");
//        }
    }

    private void saveMoviedata() {
        //插入数据
        Movie movie = new Movie("你的名字3", 201000);
        getMovieDao().save(movie);
    }

    private void queryMoviedata() {
        //查询数据详细
        List<Movie> movies = getMovieDao().loadAll();
        Log.i("My_Log", "当前数量：" + movies.size());
        for (int i = 0; i < movies.size(); i++) {
            Log.i("My_Log", "结果：" + movies.get(i).getName() + "," + movies.get(i).getYear() + ";");
        }

    }


    private UserDao getUserDao() {
        return GreenDaoManager.getInstance().getSession().getUserDao();
    }

    private MovieDao getMovieDao(){
        return GreenDaoManager.getInstance().getSession().getMovieDao();
    }



}
