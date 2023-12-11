package com.uladzislaumak.firstproject.view.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uladzislaumak.firstproject.databinding.FilmItemBinding
import com.uladzislaumak.firstproject.domain.Film

//в параметр передаем слушатель, чтобы мы потом могли обрабатывать нажатия из класса активити
class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<FilmListRecyclerAdapter.FilmViewHolder>() {
    //Здесь у нас хранится список элементов для RV
    private val items = mutableListOf<Film>()

    //Этот метод нужно переопределить на возврат количества елементов в списке RV
    override fun getItemCount() = items.size

    //В этом методе мы привязываем наш view holder и передаем туда "надутую" верстку нашего фильма
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = FilmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    //В этом методе будет привзяка полей из объекта Film, к view из film_item.xml
    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        //Вызываем метод bind(), который мы создали и передаем туда объект
        //из нашей базы данных с указанием позиции
        holder.bind(items[position])
        //Обрабатываем нажатие на весь элемент целиком(можно сделать на отдельный элемент
        //напрмер, картинку) и вызываем метод нашего листенера, который мы получаем из
        //конструктора адаптера
        holder.binding.itemContainer.setOnClickListener {
            clickListener.click(items[position])
        }
    }

    //Метод для добавления объектов в наш список
    fun addItems(list: List<Film>) {
        //Сначала очишаем(если не реализовать DiffUtils)
        items.clear()
        //Добавляем
        items.addAll(list)
        //Уведомляем RV, что пришел новый список и ему нужно заново все "привязывать"
        notifyDataSetChanged()
    }

    //Интерфейс для обработки кликов
    interface OnItemClickListener {
        fun click(film: Film)
    }

    // ViewHolder с использованием ViewBinding
    inner class FilmViewHolder(val binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
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
}
