package com.example.tasksla

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tarefas",
                        fontWeight = FontWeight.Bold,
                        fontSize = 27.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 62.dp),
                        textAlign = TextAlign.Center,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        CoroutineScope(Dispatchers.Default).launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                backgroundColor = Color(100, 200, 15),
            )
        },
        drawerContent = {
            Box(
                modifier = Modifier
                    .background(Color.Magenta)
                    .height(16.dp)
            ) {
                Text(text = "Options")
            }
            Column {
                Text(text = "Option 1")
            }
        },
        content = { paddingValues ->
            Log.i("paddingValues", "$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
            ) {
                Search(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(252, 251, 250))
                )
                Widget(
                    modifier = Modifier.fillMaxWidth(),
                    taskname = "Jogar The Witcher 3",
                    taskdetail = "Explorar o mundo aberto e completar missões",
                    deadEndDate = Date(System.currentTimeMillis())
                )
                Widget(
                    modifier = Modifier.fillMaxWidth(),
                    taskname = "Concluir 100% do GTA V",
                    taskdetail = "Realizar todas as missões e atividades do jogo",
                    deadEndDate = Date(System.currentTimeMillis())
                )
            }
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    Text(
                        text = "Kauan Mendes",
                        color = Color.White,
                        fontSize = 50.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                },
                Color(100, 200, 15).also { backgroundColor = it },
                var modifier : kotlin . Any ? = Modifier
            modifier = Modifier.fillMaxWidth(),
            )
        }
    )
}


