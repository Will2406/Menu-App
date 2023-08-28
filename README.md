# MenuApp for Yape

Esta demo es una app de recetas, donde he puesto a prueba mis habilidades y conocimiento, el diseño fue inspirado en https://dribbble.com/shots/20647077-Healthy-Food-Delivery-App y se utilizo https://www.mockable.io para el mock de los servicios, asi poder consumir data desde un 'servidor'. 

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/chatapp-95bb6.appspot.com/o/Screenshot%202023-08-28%20at%2013.53.35.png?alt=media&token=776830a2-8bb9-4b59-ae6c-27f4fe7f570e" width="250" >
  <img src="https://firebasestorage.googleapis.com/v0/b/chatapp-95bb6.appspot.com/o/Screenshot%202023-08-28%20at%2013.53.55.png?alt=media&token=0cd142ac-8834-48d8-b966-9adc6cb9336c" width="250">
    <img src="https://firebasestorage.googleapis.com/v0/b/chatapp-95bb6.appspot.com/o/Screenshot%202023-08-28%20at%2013.54.05.png?alt=media&token=94a58f92-77a4-46ee-b611-567076ceeac6" width="250" >
</p>

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/chatapp-95bb6.appspot.com/o/Screenshot%202023-08-28%20at%2013.53.45.png?alt=media&token=6cc1121e-eafe-4781-bea9-8dce312ed47c" width="250">
  <img src="https://firebasestorage.googleapis.com/v0/b/chatapp-95bb6.appspot.com/o/Screenshot%202023-08-28%20at%2013.54.30.png?alt=media&token=2c45ae17-3917-49b3-97b7-9b5d132d2117" width="250">
</p>


## Características del App

**Exploración en Tendencia**: Descubre comidas populares al instante con una lista de platos destacados en tiempo real.

 **Detalles y Búsqueda**: Explora detalles exhaustivos de cada comida y encuentra platos específicos a través de la búsqueda por nombre. Obtén información completa sobre ingredientes, preparación y más.

 **Función de Geolocalización**: Encuentra restaurantes cercanos que sirven tu comida elegida, utilizando servicios de mapas.

 **Interfaz de Usuario Intuitiva**: Disfruta de una experiencia fluida y amigable al navegar por las características de la aplicación.


### Estructura de la Aplicación

<p align="center">
  <img src="https://firebasestorage.googleapis.com/v0/b/chatapp-95bb6.appspot.com/o/DATA%20LAYER.png?alt=media&token=5f1abe01-60be-4303-a827-9fd0eaea08c5)" width="250" >
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

- **Carga de Imágenes**: Coil para cargar imágenes de manera eficiente en la interfaz de usuario.

- **Programación Reactiva**: Flow se utiliza para la programación reactiva en diferentes partes de la aplicación.

- **Integración de Google Maps**: API de Google Maps para mostrar ubicaciones de restaurantes.

- **Inyección de Dependencias**: Hilt Dagger se utiliza para la inyección de dependencias y la gestión de la creación de instancias.

