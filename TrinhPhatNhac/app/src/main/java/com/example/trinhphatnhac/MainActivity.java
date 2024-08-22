package com.example.trinhphatnhac;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.trinhphatnhac.databinding.ActivityMainBinding;

//VIEWBINDING

//CHÚ ý: khi mà sử dụng finByid đó mà quên ánh xạ thì nó sẽ bị null
//còn sử dụng viewBinding thì nó phải tồi tại trong file xml thì mới truy xuất được
//viewBinding Tự đông match kiểu view tránh ánh xạ view sai Type
//
public class MainActivity extends AppCompatActivity {
//làm theo hướng dẫn java nhưng mà mở trang web viewbinding ra mà làm kotlin
 private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        khoi tao
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.btnClick.setOnClickListener(v ->
                openMyFragment());

    }

    private void openMyFragment() {
        MyFragment myFragment = new MyFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, myFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }
}