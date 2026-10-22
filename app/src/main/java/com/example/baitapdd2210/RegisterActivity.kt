package com.example.baitapdd2210



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.baitapdd2210.databinding.ActivityRegisterBinding
import com.example.baitapdd2210.utils.ValidationUtils
import com.example.baitapdd2210.utils.trimmedText

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRealtimeValidation()
        setupListeners()
    }

    private fun setupRealtimeValidation() {
        binding.edtName.doAfterTextChanged { binding.tilName.error = null }
        binding.edtEmail.doAfterTextChanged { binding.tilEmail.error = null }
        binding.edtPhone.doAfterTextChanged { binding.tilPhone.error = null }
        binding.edtMsv.doAfterTextChanged { binding.tilMsv.error = null }
        binding.edtClass.doAfterTextChanged { binding.tilClass.error = null }
    }

    private fun setupListeners() {
        binding.btnRegister.setOnClickListener {
            if (validateForm()) {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("EXTRA_NAME", binding.edtName.trimmedText())
                    putExtra("EXTRA_EMAIL", binding.edtEmail.trimmedText())
                    putExtra("EXTRA_PHONE", binding.edtPhone.trimmedText())
                    putExtra("EXTRA_MSV", binding.edtMsv.trimmedText())
                    putExtra("EXTRA_CLASS", binding.edtClass.trimmedText())
                }
                startActivity(intent)
            }
        }

        binding.btnGoToDetail.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        val name = binding.edtName.trimmedText()
        val email = binding.edtEmail.trimmedText()
        val phone = binding.edtPhone.trimmedText()
        val msv = binding.edtMsv.trimmedText()
        val className = binding.edtClass.trimmedText()

        if (!ValidationUtils.isValidName(name)) {
            binding.tilName.error = "Họ tên không được để trống (tối thiểu 2 ký tự)"
            isValid = false
        }

        if (!ValidationUtils.isValidEmail(email)) {
            binding.tilEmail.error = "Email không đúng định dạng (vd: abc@domain.com)"
            isValid = false
        }

        if (!ValidationUtils.isValidPhone(phone)) {
            binding.tilPhone.error = "Số điện thoại không hợp lệ (10 số, bắt đầu bằng 0)"
            isValid = false
        }

        if (!ValidationUtils.isValidMsv(msv)) {
            binding.tilMsv.error = "Mã sinh viên không hợp lệ (từ 6-15 ký tự)"
            isValid = false
        }

        if (!ValidationUtils.isValidClass(className)) {
            binding.tilClass.error = "Lớp không được để trống"
            isValid = false
        }

        return isValid
    }
}