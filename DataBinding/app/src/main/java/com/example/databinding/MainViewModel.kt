package com.example.databinding

import android.util.Log
import android.view.View

//xử lý ràng buộc dữ liệu của activity
    data class MainViewModel (
        val name : String
    )

    data class MyFragmentViewModel(
        val name : String
    )

    class MyHandlers {
//        Có tham số
//        fun showLog(view: View) {
//            Log.d("Tinder", "ok không")
//        }
        // Không tham số

        fun showLog() {
        Log.d("Tinder", "ok không")
    }
        fun showLog1(mes: String) {
            Log.d("Tinder", mes)
        }

//        Có thêm tham số view, nếu như cần sử dụng đến view
        fun showLog2(view: View, mes: String) {
            Log.d("Tinder", mes)
        }

        fun showLog3(mainViewModel: MainViewModel) {
            Log.d("Tinder", mainViewModel.name + "-"  )
        }

    }
