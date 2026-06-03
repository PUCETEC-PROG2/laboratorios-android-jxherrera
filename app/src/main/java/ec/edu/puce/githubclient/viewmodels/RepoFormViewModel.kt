package ec.edu.puce.githubclient.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ec.edu.puce.githubclient.models.RepositoryPayload
import ec.edu.puce.githubclient.services.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RepoFormViewModel: ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMsg = MutableStateFlow<String?>(null)
    val errorMsg: StateFlow<String?> = _errorMsg.asStateFlow()
    private val _inSuccess = MutableStateFlow(false)
    val inSuccess: StateFlow<Boolean> = _inSuccess.asStateFlow()

    init {
        _errorMsg
    }
    fun createRepo (name: String, description: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            try {
                val repoBody = RepositoryPayload(name,description)
                RetrofitClient.apiService.createRepository( repoBody)
                _inSuccess.value = true
            } catch (e: Exception) {
                _errorMsg.value = "Error al cargar: ${e.localizedMessage}"
            }finally {
                _isLoading.value = false
            }
        }
    }

    fun updateRepo(owner: String, repoName: String, name: String, description: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            try {
                val repoBody = RepositoryPayload(name, description)
                RetrofitClient.apiService.updateRepository(owner, repoName, repoBody)
                _inSuccess.value = true
            } catch (e: Exception) {
                _errorMsg.value = "Error al actualizar: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteRepo(login: String, name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMsg.value = null
            try {
                RetrofitClient.apiService.deleteRepository(login, name)
                _inSuccess.value = true
            } catch (e: Exception) {
                _errorMsg.value = "Error al cargar: ${e.localizedMessage}"
            }
        }
    }

    fun resetSuccess() {
        _inSuccess.value = false
    }
    fun resetError() {
        _errorMsg.value = null
    }

}