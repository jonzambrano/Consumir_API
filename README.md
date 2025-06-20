# App de Turismo Quevedo - Consumo de API en Android

Aplicación Android nativa, desarrollada en Java, como demostración del consumo de servicios web (API RESTful) para obtener y mostrar información. El proyecto se centra en la visualización de lugares turísticos de la ciudad de Quevedo, Ecuador.

## 📋 Descripción

Este proyecto implementa las siguientes funcionalidades:

- **Pantalla de Lugares Turísticos:** Consume una API para obtener una lista de lugares turísticos y los muestra en la interfaz de usuario.
  
![Imagen de WhatsApp 2025-06-20 a las 17 38 43_58940503aa](https://github.com/user-attachments/assets/f61de570-c32b-4474-aa8f-30c3981b63ca)

El objetivo principal es demostrar la conexión a APIs externas desde una aplicación Android utilizando clases personalizadas para manejar las peticiones web en segundo plano.

## ✨ Características

- **Consumo de API RESTful:** Conexión a endpoints en formato JSON.
- **Manejo de Peticiones Asíncronas:** Se utiliza una implementación personalizada basada en `AsyncTask` para evitar bloquear el hilo principal de la UI.
- **Análisis de JSON (Parsing):** Se utiliza la librería nativa `org.json` de Android para procesar las respuestas de la API.
- **Interfaz de Usuario Sencilla:** Diseño básico para mostrar los resultados obtenidos de los servicios web.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java
- **Plataforma:** Android Nativo
- **Manejo de Red:** `WebService` y `Asynchtask` (clases personalizadas)
- **Análisis de Datos:** `org.json` (JSONObject, JSONArray)
