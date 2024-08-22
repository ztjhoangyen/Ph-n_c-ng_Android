package com.example.databinding
//8
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databinding.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    // Chỉ khai báo biến binding mà không khởi tạo nó ở đây
    private lateinit var binding: FragmentBlankBinding
//    phải khai báo thì mới sử dụng hàm ở xml được
    private lateinit var handlers: MyHandlers

    private val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        // Khởi tạo binding bên trong onCreateView
        binding = FragmentBlankBinding.inflate(inflater, container, false)

        val obj = MyFragmentViewModel(
            name = "fragment khó ở"
        )
        binding.myFragmentViewModel = obj

//        set dữ liệu cho bên xml


        val user = listOf(
            MainViewModel("Join")
        )

        //        set dữ liệu mainViewModel cho bên xml
        val objuser = MainViewModel(
            name = "user hem"
        )
        binding.mainViewModel = objuser


// CHÚ Ý: thêm tí coi lại tại sao
        handlers = MyHandlers()
        binding.myHandlers = handlers

        binding.rcl.layoutManager = LinearLayoutManager(context)
        binding.rcl.adapter = UserAdapter(user)
//    viewModel
        binding.viewModel = viewModel
//        binding.lifecycleOwner = this
        binding.lifecycleOwner = viewLifecycleOwner

        // Ví dụ: Thay đổi trạng thái của checkbox
//        binding.checkbox.isChecked = viewModel.checkboxState.value ?: false

        // Xử lý thay đổi trạng thái của CheckBox
        // Xử lý thay đổi trạng thái của CheckBox
        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
            viewModel.setCheckboxState(isChecked)
            Log.d("CheckboxState", "CheckBox checked: ${isChecked}")

        }
        // Thêm đoạn mã này để debug
//        viewModel.checkboxState.observe(viewLifecycleOwner) { isChecked ->
//            Log.d("CheckboxState", "Checkbox is checked: $isChecked")
//        }
//        binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
//            // Log để kiểm tra giá trị
//            Log.d("CheckboxState", "CheckBox checked: $isChecked")
//            viewModel.setCheckboxState(isChecked)
//        }


        // Trả về root view của binding
        return binding.root

     }

}