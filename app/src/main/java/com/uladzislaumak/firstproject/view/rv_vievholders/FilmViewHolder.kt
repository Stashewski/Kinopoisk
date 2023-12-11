package com.uladzislaumak.firstproject.view.rv_vievholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uladzislaumak.firstproject.databinding.FilmItemBinding
import com.uladzislaumak.firstproject.domain.Film

class FilmViewHolder(private val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {

    //В этом методе кладем данные из film в наши view
    fun bind(film: Film) {
        //Устанавливаем заголовок
        binding.title.text = film.title
        //Устанавливаем постер
        //Указываем контейнер, в котором будет "жить" наша картинка
        Glide.with(binding.root)
            //Загружаем сам ресурс
            .load(film.poster)
            //Центруем изображение
            .centerCrop()
            //Указываем ImageView, куда будем загружать изображение
            .into(binding.poster)
        //Устанавливаем описание
        binding.description.text = film.description
    }
}
