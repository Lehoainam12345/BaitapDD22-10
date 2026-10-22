package com.example.baitapdd2210

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baitapdd2210.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    private val name by lazy { intent.getStringExtra("EXTRA_NAME") ?: "Chưa có thông tin" }
    private val email by lazy { intent.getStringExtra("EXTRA_EMAIL") ?: "Chưa có thông tin" }
    private val phone by lazy { intent.getStringExtra("EXTRA_PHONE") ?: "Chưa có thông tin" }
    private val msv by lazy { intent.getStringExtra("EXTRA_MSV") ?: "Chưa có thông tin" }
    private val className by lazy { intent.getStringExtra("EXTRA_CLASS") ?: "Chưa có thông tin" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayData()

        binding.btnBackToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)
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