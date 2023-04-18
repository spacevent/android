package com.example.spacevent.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.spacevent.ui.theme.Alpha

/**
 * Ввод текста с появлением текста ошибки при необходимости
 * @param[value] Отображаемый текст
 * @param[onValueChange] Функция обновления текста
 * @param[visualTransformation] Интерфейс для изменения визуального отображения текста
 * @param[rightIcon] Composable функция для отображения контента справа от текста
 * @param[errorText] Текст сообщения об ошибке
 * @param[isError] Флаг появления ошибки. При значении true появляется отображение текста об ошибке
 * @param[labelText] Подсказка о содержании ввода текста
 * @param[enabled] Флаг активности элемента. При значении false пользователь не может изменять текст
 * @param[modifier] Модификатор элемента
 * "@param[paddingValues] Значение отступов
 * "@param[keyboardOptions] Конфигурация клавиатуры
*/

@Composable
fun TextFieldsWithLabelError(
    value: String,
    onValueChange: (newValue: String) -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    rightIcon: @Composable () -> Unit = {},
    errorText: String = "",
    labelText: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    modifier: Modifier = Modifier.fillMaxWidth(),
    paddingValues: PaddingValues = PaddingValues(horizontal = 32.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions()
) {
    Column {
        TextField(
            value = value,
            onValueChange = { text -> onValueChange(text) },
            modifier = modifier.padding(paddingValues),
            enabled = enabled,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Alpha,
                textColor = MaterialTheme.colors.onSurface
            ),
            trailingIcon = { rightIcon() },
            label = { Text(labelText) },
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            isError = isError
        )

        if (isError) {
            Text(
                text = errorText,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(paddingValues).padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun AppTextField(
    value: String,
    onValueChange: (newValue: String) -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    rightIcon: @Composable () -> Unit = {},
    labelText: String = "",
    enabled: Boolean = true,
    modifier: Modifier = Modifier.fillMaxWidth(),
    paddingValues: PaddingValues = PaddingValues(horizontal = 0.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions()
) {
    TextField(
        value = value,
        onValueChange = { text -> onValueChange(text) },
        modifier = modifier.padding(paddingValues),
        enabled = enabled,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Alpha,
            textColor = MaterialTheme.colors.onSurface
        ),
        trailingIcon = { rightIcon() },
        label = { Text(labelText) },
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
    )
}