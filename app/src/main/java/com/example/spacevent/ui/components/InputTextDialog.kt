package com.example.spacevent.ui.components

import TextFieldDate
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.spacevent.R
import com.example.spacevent.model.emptities.Rate
import com.example.spacevent.model.emptities.Request
import java.util.*

@Composable
fun InputTextDialog(
    service: String,
    rates: List<Rate>,
    onDismissRequest: () -> Unit,
    createRequest: (request: Request) -> Unit
) {
    Dialog(
        onDismissRequest = { onDismissRequest() },
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier
                    .size(32.dp)
                    .align(Alignment.TopEnd),
                onClick = {
                    onDismissRequest()
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cross),
                    contentDescription = "back",
                    tint = MaterialTheme.colors.onSurface,
                )
            }

            var contact by remember { mutableStateOf("") }
            var rate by remember { mutableStateOf<Rate?>(null) }
            var startTime by remember { mutableStateOf("") }
            var endTime by remember { mutableStateOf("") }
            var date by remember { mutableStateOf<Calendar?>(null) }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp, top = 8.dp),
                elevation = 16.dp,
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Оставить заявку", style = MaterialTheme.typography.h5)

                    AppTextField(
                        labelText = "Ваши контакты для связи",
                        value = contact,
                        onValueChange = { contact = it })
                    AppTextField(
                        labelText = "Начало мероприятия",
                        value = startTime,
                        onValueChange = { startTime = it })
                    AppTextField(
                        labelText = "Конец мероприятия",
                        value = endTime,
                        onValueChange = { endTime = it })


                    Spinner(hint = rate?.name ?: "Выберите тариф") { hide ->
                        rates.forEach {
                            DropdownMenuItem(onClick = {
                                hide()
                                rate = it
                            }) {
                                Text(text = it.name, Modifier.padding(horizontal = 16.dp))
                            }
                        }
                    }

                    TextFieldDate(labelText = "Выберите дату", currentDate = date) {

                    }

                    Button(
                        enabled = contact.isNotEmpty()
                                && rate != null && startTime.isNotEmpty()
                                && endTime.isNotEmpty() && date != null,
                        onClick = {
                            createRequest(
                                Request(
                                    service = service,
                                    contact = contact,
                                    rate = rate!!.name,
                                    startTime = startTime,
                                    endTime = endTime,
                                    date = date!!.time
                                )
                            )
                        }
                    ) {
                        Text(text = "Отправить заявку")
                    }
                }
            }
        }
    }
}