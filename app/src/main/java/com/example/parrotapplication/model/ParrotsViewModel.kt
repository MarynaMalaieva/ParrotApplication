package com.example.parrotapplication.model

import androidx.lifecycle.ViewModel
import com.example.parrotapplication.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ParrotsViewModel: ViewModel() {
    val parrots =  MutableStateFlow<List<Parrot>>(emptyList())

    fun getById(id: String) = parrots.value.first { parrot -> parrot.id == id }

    init {
        parrots.update {
            mutableListOf(
                Parrot(
                    id = "1",
                    name = "Ozzy",
                    age = 12,
                    sex = "male",
                    breed = "Scarlet Macaw",
                    avatar = R.drawable.scarletmacaw_1
                ),
                Parrot(
                    id = "2",
                    name = "Alex",
                    age = 8,
                    sex = "male",
                    breed = "African Grey",
                    avatar = R.drawable.africangreyparrot_1
                ),
                Parrot(
                    id = "3",
                    name = "Abby",
                    age = 6,
                    sex = "female",
                    breed = "Cockatiel",
                    avatar = R.drawable.cockatiel
                ),
                Parrot(
                    id = "4",
                    name = "Coco",
                    age = 9,
                    sex = "male",
                    breed = "Peach Faced Parakeet",
                    avatar = R.drawable.peachfacedparakeet
                ),
                Parrot(
                    id = "5",
                    name = "Kiki",
                    age = 11,
                    sex = "female",
                    breed = "Rosy Faced Lovebird",
                    avatar = R.drawable.rosyfacedlovebird
                ),
                Parrot(
                    id = "6",
                    name = "Scooby",
                    age = 17,
                    sex = "male",
                    breed = "Rose Ringed Parakeet",
                    avatar = R.drawable.rose_ringed_parakeet
                ),
                Parrot(
                    id = "7",
                    name = "Oliver",
                    age = 5,
                    sex = "male",
                    breed = "Budgerigar",
                    avatar = R.drawable.budgerigar_1_1
                ),
                Parrot(
                    id = "8",
                    name = "Oscar",
                    age = 8,
                    sex = "male",
                    breed = "Budgerigar",
                    avatar = R.drawable.budgerigar_2
                ),
                Parrot(
                    id = "9",
                    name = "Pixie",
                    age = 8,
                    sex = "female",
                    breed = "Budgerigar",
                    avatar = R.drawable.budgerigar_3
                ),
                Parrot(
                    id = "10",
                    name = "Angel",
                    age = 5,
                    sex = "female",
                    breed = "Budgerigar",
                    avatar = R.drawable.budgerigar_4
                )
            )
        }
    }
}