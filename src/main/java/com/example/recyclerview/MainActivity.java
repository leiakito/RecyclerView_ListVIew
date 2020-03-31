package com.example.recyclerview;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.adapters.ListViewAdapter;
import com.example.recyclerview.beans.Datas;
import com.example.recyclerview.beans.ItemBean;

import java.util.ArrayList;
import java.util.List;

/***
 * 总结1,首先我们要有控件 RecyclerView 网上搜索androidx包下     implementation 'com.androidx.support:recyclerview-v7:+'
 *  添加RecyclerView的依赖 这样才能在布局文件中使用RecyclerView控件
 *  2.findViewbyid找到控件
 *  3.准备好数据
 *  4.设置布局管理器
 *  5.创建适配器
 *  6.设置适配器
 *  7.数据展示
 */
public class MainActivity extends AppCompatActivity {
    final String TAG = "MainActivity";
    public RecyclerView view;
    private List<ItemBean> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件recycler_view
        view = findViewById(R.id.recycler_view);
        //准备数据
        /**
         * 准备数据,一般来说,在开发中,数据从网络中获取,这里演示从本地
         */
        initData();
    }

    //这个方法用于初始化模拟数据
    private void initData() {
        //list<DataBean> -----Adapter ----setAdapter----->显示数据
        //创建集合
        datas = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i <Datas.icons.length; i++) {
            //创建数据对象 并添加数据
            ItemBean data = new ItemBean();
            data.icon = Datas.icons[i];
            data.title = "我是第"+i+"个条目";
            //将数据对象添加到集合中
            datas.add(data);
        }
        //RecyclerView 设置布局管理器样式  设置布局管理器 Manager
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        view.setLayoutManager(layoutManager);
        //创建适配器
        ListViewAdapter adapter=new ListViewAdapter(datas);
        //设置适配器RecyclerView中去
        view.setAdapter(adapter);
    }

    //加载onCreateOptionsMenu 加载menu菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //当选中menu中的item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //获取item中的id
        int itemId = item.getItemId();
        //switch判断选中的id
        switch (itemId) {
            //List_View部分的menu
            //list_view垂直标准
            case R.id.list_view_vertical_stander:
                Log.d(TAG, "点击了ListView里的垂直标准");
                break;
            //list_view垂直反向
            case R.id.list_view_vertical_reverse:
                Log.d(TAG, "点击了ListView里的垂直反向");
                break;
            //list_view水平横线
            case R.id.list_view_horizontal_stander:
                Log.d(TAG, "点击了ListView里的水平横线");
                break;
            //list_view水平反向
            case R.id.list_view_horzontal_reverse:
                Log.d(TAG, "点击了ListView里的水平反向");
                break;
            //Grid_View部分的menu
            //Grid_view的垂直标准
            case R.id.grid_view_vertical_stander:
                Log.d(TAG, "点击了GridView里的垂直标准");
                break;
            //Grid_view的垂直反向
            case R.id.grid_view_vertical_reverse:
                Log.d(TAG, "点击了GridView里的垂直反向");
                break;
            //Grid_view的水平横线
            case R.id.grid_view_horizontal_stander:
                Log.d(TAG, "点击了GridView里的水平横线");
                break;
            //Gird_view的水平反向
            case R.id.grid_view_horzontal_reverse:
                Log.d(TAG, "点击了GridView里的水平反向");
                break;

            //stagger_view部分的menu
            //stagger瀑布流的垂直标准
            case R.id.stagger_view_vertical_stander:
                Log.d(TAG, "点击了StaggerView里的垂直标准");
                break;
            //stagger的垂直反向
            case R.id.stagger_view_vertical_reverse:
                Log.d(TAG, "点击了StaggerView里的垂直反向");
                break;
            //stagger的水平横线
            case R.id.stagger_view_horizontal_stander:
                Log.d(TAG, "点击了StaggerView里的水平横线");
                break;
            //stagger的水平反向
            case R.id.stagger_view_horzontal_reverse:
                Log.d(TAG, "点击了StaggerView里的水平反向");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
