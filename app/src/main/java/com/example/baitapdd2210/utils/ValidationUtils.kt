package com.example.baitapdd2210.utils

import android.content.Context
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast

// Extension lấy chuỗi đã cắt khoảng trắng
fun EditText.trimmedText(): String = text.toString().trim()

// Extension hiển thị Toast nhanh
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// Đối tượng hỗ trợ kiểm tra Validation
object ValidationUtils {
    fun isValidName(name: String): Boolean {
        return name.isNotBlank() && name.length >= 2
    }

    fun isValidEmail(email: String): Boolean {
        return email.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPhone(phone: String): Boolean {
        val phoneRegex = "^(0[3|5|7|8|9])+([0-9]{8})$".toRegex()
        return phone.matches(phoneRegex)
    }

    fun isValidMsv(msv: String): Boolean {
        return msv.isNotBlank() && msv.length in 6..15
    }

    fun isValidClass(className: String): Boolean {
        return className.isNotBlank()
    }
}
