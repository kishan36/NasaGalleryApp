package com.app.nasagalleryapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.nasagalleryapp.NasaDataRepository
import com.app.nasagalleryapp.models.DataModel
import com.app.nasagalleryapp.utils.PageState
import com.app.nasagalleryapp.utils.Result
import kotlinx.coroutines.launch

class ImageListingViewModel(private val imagesRepository: NasaDataRepository) : ViewModel() {


    private val _images = MutableLiveData<List<DataModel>>(listOf())
    val images: LiveData<List<DataModel>>
        get() = _images

    private val _pageState = MutableLiveData<PageState>(PageState.Initial)
    val pageState: LiveData<PageState>
        get() = _pageState

    private fun fetchImages() {
        viewModelScope.launch {
            _pageState.postValue(PageState.InProgress)
            when (val result = imagesRepository.getImages()) {
                is Result.Error -> _pageState.postValue(PageState.Error)
                is Result.Success -> {
                    result.data.let {
                        _images.postValue(it.sortedByDescending { it.date })
                        if (it.isEmpty()) {
                            _pageState.postValue(PageState.EmptyData)
                        } else {
                            _pageState.postValue(PageState.Data)
                        }
                    }
                }
            }
        }
    }

    init {
        fetchImages()
    }
}