package com.example.todolistcompose

import android.app.Application
import com.example.todolistcompose.dependencyinjection.DependencyInjector

class ToDoApplication: Application() {

    lateinit var dependencyInjector: DependencyInjector

    override fun onCreate() {
        super.onCreate()
        initDependencyInjector()
    }

    private fun initDependencyInjector() {
        dependencyInjector = DependencyInjector(this)
    }

}