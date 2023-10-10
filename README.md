# MenuApp

[![Everything Is AWESOME](https://firebasestorage.googleapis.com/v0/b/menu-app-80590.appspot.com/o/Untitled%20design-2.png?alt=media&token=dc664e53-26e7-48bf-adc3-4c19c11ea369&_gl=1*hzavzr*_ga*MTc1MjMyMTM2NC4xNjczMzgwOTc0*_ga_CW55HF8NVT*MTY5Njk3Njk0OC4zMS4xLjE2OTY5NzY5NjUuNDMuMC4w)](https://www.youtube.com/shorts/x75BY98uSBw)


Esta demo es una app de recetas, donde he puesto a prueba mis habilidades y conocimiento, el diseño fue inspirado en https://dribbble.com/shots/20647077-Healthy-Food-Delivery-App y se utilizo https://www.mockable.io para el mock de los servicios, asi poder consumir data desde un 'servidor'. 

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/menu-app-80590.appspot.com/o/Screenshot%202023-08-28%20at%2013.53.35.png?alt=media&token=c555acfc-5bbb-46c2-b5b4-229f70934b70&_gl=1*z1y7mh*_ga*MTc1MjMyMTM2NC4xNjczMzgwOTc0*_ga_CW55HF8NVT*MTY5Njk3Njk0OC4zMS4xLjE2OTY5NzcwNTkuNTMuMC4w" width="250" >
  <img src="https://firebasestorage.googleapis.com/v0/b/menu-app-80590.appspot.com/o/Screenshot%202023-08-28%20at%2013.53.55.png?alt=media&token=16eb4f15-ec0d-43f9-a5ad-33f01bfa682e&_gl=1*15asnf1*_ga*MTc1MjMyMTM2NC4xNjczMzgwOTc0*_ga_CW55HF8NVT*MTY5Njk3Njk0OC4zMS4xLjE2OTY5NzcxMjEuNTcuMC4w" width="250">
    <img src="https://firebasestorage.googleapis.com/v0/b/menu-app-80590.appspot.com/o/Screenshot%202023-08-28%20at%2013.54.05.png?alt=media&token=e04fd6cf-7b96-4f6b-91a3-a84f121bc442&_gl=1*1s6q5l6*_ga*MTc1MjMyMTM2NC4xNjczMzgwOTc0*_ga_CW55HF8NVT*MTY5Njk3Njk0OC4zMS4xLjE2OTY5NzcxNDMuMzUuMC4w" width="250" >
</p>

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/menu-app-80590.appspot.com/o/Screenshot%202023-08-28%20at%2013.54.30.png?alt=media&token=b150c0d8-e503-4593-b537-5f0109502c4a&_gl=1*1b6tm6i*_ga*MTc1MjMyMTM2NC4xNjczMzgwOTc0*_ga_CW55HF8NVT*MTY5Njk3Njk0OC4zMS4xLjE2OTY5NzcxNTkuMTkuMC4w" width="250">
  <img src="https://firebasestorage.googleapis.com/v0/b/menu-app-80590.appspot.com/o/Screenshot%202023-08-28%20at%2013.53.45.png?alt=media&token=cad3ce70-381b-4e02-889a-c63860a110bb&_gl=1*cmxr0u*_ga*MTc1MjMyMTM2NC4xNjczMzgwOTc0*_ga_CW55HF8NVT*MTY5Njk3Njk0OC4zMS4xLjE2OTY5NzcxODAuNTkuMC4w" width="250">
</p>


## Características del App

**Exploración en Tendencia**: Descubre comidas populares al instante con una lista de platos destacados en tiempo real.

 **Detalles y Búsqueda**: Explora detalles exhaustivos de cada comida y encuentra platos específicos a través de la búsqueda por nombre. Obtén información completa sobre ingredientes, preparación y más.

 **Función de Geolocalización**: Encuentra restaurantes cercanos que sirven tu comida elegida, utilizando servicios de mapas.

 **Función de guardar tus recetas favoritas**: Ten la opcion de guardar las mejores recetas y revisarlas en cualquier momento(offline).

 **Interfaz de Usuario Intuitiva**: Disfruta de una experiencia fluida y amigable al navegar por las características de la aplicación.


### Estructura de la Aplicación

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/menu-app-80590.appspot.com/o/DATA%20LAYER.png?alt=media&token=47b341f5-6f4a-4f0b-ac98-5edf2409b35e&_gl=1*q9epem*_ga*MTc1MjMyMTM2NC4xNjczMzgwOTc0*_ga_CW55HF8NVT*MTY5Njk3Njk0OC4zMS4xLjE2OTY5NzcyMDMuMzYuMC4w" width="250" >
</p>

La aplicación sigue una estructura organizada en capas, basada en el principio de Clean Architecture, para lograr una separación clara de responsabilidades:

- **Capa de Datos (Data)**: Dividida en datasources, con **Remote** para acceso a datos remotos y **Local** para acceso a datos almacenados localmente. Ambas son gestionadas por la clase **Repository**, que decide la fuente de datos en función de la lógica específica.

  La carpeta **core** en la capa de datos incluye el **API Service** configurado con Retrofit, que se comunica con las fuentes remotas de datos. Además, aquí se definen los modelos de datos específicos para esta capa.

- **Capa de Dominio (Domain)**: Aquí se definen los **casos de uso** que representan las operaciones de negocio de la aplicación, junto con los modelos de datos del dominio que contienen la información requerida para los casos de uso.

### Estructura de la Interfaz de Usuario (UI)

La capa de UI está organizada en **features** para una mejor modularidad y mantenibilidad.

Cada **feature** incluye:

- **ViewModel**: Actúa como intermediario entre la interfaz de usuario y la capa de dominio, gestionando la lógica de presentación y proporcionando datos a la interfaz de usuario. El patrón MVVM se aplica aquí para separar la lógica de la vista.

- **Screen**: Representa la interfaz de usuario utilizando Jetpack Compose. Define el diseño y la estructura de la pantalla.

- **State**: Administra los diferentes estados posibles de la vista. Cada cambio en la interfaz de usuario se refleja a través de diferentes estados.

### Tecnologías Utilizadas

- **Lenguaje de Programación**: Kotlin

- **Plataforma de Desarrollo**: Android Studio

- **Arquitectura**: Clean Architecture, con separación clara de responsabilidades en capas.

- **Patrón MVVM**: Cada feature de la interfaz de usuario sigue el patrón MVVM, con ViewModels para manejar la lógica y el estado de la vista.

- **Patrón Repository**: La capa de datos utiliza el patrón Repository para abstraer y gestionar las fuentes de datos.

- **Comunicación de Red**: Retrofit para comunicarse con las fuentes de datos remotas.

- **Guardado de datos en Local**: Room para uso de datos de manera de local sin necesidad de internet.

- **Carga de Imágenes**: Coil para cargar imágenes de manera eficiente en la interfaz de usuario.

- **Programación Reactiva**: Flow se utiliza para la programación reactiva en diferentes partes de la aplicación.

- **Integración de Google Maps**: API de Google Maps para mostrar ubicaciones de restaurantes.

- **Inyección de Dependencias**: Hilt Dagger se utiliza para la inyección de dependencias y la gestión de la creación de instancias.

