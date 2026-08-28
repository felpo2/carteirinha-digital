package com.senaisp.carteirinhadigital.feature.login.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUIState())
}