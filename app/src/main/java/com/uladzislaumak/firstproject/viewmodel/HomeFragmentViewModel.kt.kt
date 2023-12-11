package com.uladzislaumak.firstproject.viewmodel
package com.amsdevelops.firstproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amsdevelops.firstproject.App
import com.amsdevelops.firstproject.domain.Film
import com.amsdevelops.firstproject.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmsListLiveData:  MutableLiveData<List<Film>> = MutableLiveData()
    //Инициализируем интерактор
    private var interactor: Interactor = App.instance.interactor

    init {
        val films = interactor.getFilmsDB()
        filmsListLiveData.postValue(films)
    }
}