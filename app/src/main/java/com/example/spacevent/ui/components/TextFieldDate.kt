import com.example.spacevent.ui.components.HorizontalSpacer
import java.text.SimpleDateFormat

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
import com.example.spacevent.R

/**
 * Поле для выбора даты
 * @param[labelText] Подсказка о содержании ввода текста
 * @param[modifier] Модификатор элемента
 * @param[currentDate] Текущая выбранная дата типа [Calendar]
 * @param[colorLabel] Цвет подсказки
 * @param[colorIcon] Цвет иконки
 * @param[colorText] Цвет текста
 * @param[onClick] Функция, вызываемая при нажатии на иконку календаря
 */
@Composable
fun TextFieldDate(
    labelText: String,
    modifier: Modifier = Modifier,
    currentDate: Calendar?,
    colorLabel: Color = MaterialTheme.colors.onSurface,
    colorIcon: Color = MaterialTheme.colors.onSurface,
    colorText: Color = MaterialTheme.colors.onSurface,
    onClick: () -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(text = labelText, color = colorLabel, fontSize = 18.sp)

                currentDate?.let {
                    Text(text = currentDate.time.parseDateToNumberString()!!, color = colorText)
                }
            }

            IconButton(onClick = { onClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "Изменить дату",
                    tint = colorIcon
                )
            }
        }
    }
}
fun Date.parseDateToNumberString(): String? {
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(this)
}
