package com.example.baitapdd2210

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baitapdd2210.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    // Lấy dữ liệu Intent truyền sang, nếu rỗng/null thì nhận chuỗi mặc định
    private val name by lazy {
        intent.getStringExtra("EXTRA_NAME")?.takeIf { it.isNotBlank() } ?: "Chưa có thông tin"
    }
    private val email by lazy {
        intent.getStringExtra("EXTRA_EMAIL")?.takeIf { it.isNotBlank() } ?: "Chưa có thông tin"
    }
    private val phone by lazy {
        intent.getStringExtra("EXTRA_PHONE")?.takeIf { it.isNotBlank() } ?: "Chưa có thông tin"
    }
    private val msv by lazy {
        intent.getStringExtra("EXTRA_MSV")?.takeIf { it.isNotBlank() } ?: "Chưa có thông tin"
    }
    private val className by lazy {
        intent.getStringExtra("EXTRA_CLASS")?.takeIf { it.isNotBlank() } ?: "Chưa có thông tin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayData()

        // Bấm nút Quay lại: Gọi finish() để quay về màn hình Đăng ký cũ
        binding.btnBackToRegister.setOnClickListener {
            finish()
        }
    }

    private fun displayData() {
        with(binding) {
            tvName.text = "Họ và tên: $name"
            tvEmail.text = "Email: $email"
            tvPhone.text = "Số điện thoại: $phone"
            tvMsv.text = "Mã sinh viên: $msv"
            tvClass.text = "Lớp: $className"
        }
    }
}