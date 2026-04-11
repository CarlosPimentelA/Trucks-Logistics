# ✅ Backend Checklist (Ready for Frontend)

## 🧩 1. Dominio (Base del sistema)
- [✔️] Entidades definidas:
  - [✔️] Truck  
  - [✔️] TruckType  
  - [✔️] Driver    
  - [✔️] Route  
  - [✔️] Load  
  - [✔️] LoadType  
  - [✔️] Travel    
- [✔️] Relaciones correctas:
  - [✔️] Travel → Loads (1:N)  
  - [✔️] Travel → Truck (1:1)  
  - [✔️] Travel → Driver (1:1)  
- [✔️] Nombres claros y consistentes  
---

## 🗄️ 2. Base de datos [✔️]
- [✔️] Tablas creadas correctamente  
- [✔️] Foreign Keys bien definidas  
- [✔️] Sin tablas innecesarias (ej: join tables raras)  
- [✔️] Datos de prueba insertados  

---

## 🧱 3. Arquitectura del proyecto
- [✔️] Estructura por módulos:
  - [✔️] /travel
  - [✔️] /truck
  - [✔️] /driver
  - [✔️] /route
  - [✔️] /catalog
- [✔️] Controllers limpios (sin lógica)  
- [✔️] Services con lógica de negocio  
- [✔️] Repositories solo para DB  

---

## 🔗 4. Endpoints funcionando
- [ ] Travels:
  - [ ] Crear  
  - [ ] Listar  
  - [ ] Obtener por ID
  - [ ] Actualizar travel
  - [ ] Poner fecha de llegada
  - [ ] Actualizar precio gasolina

- [ ] Loads:
  - [ ] Agregar a travel
  - [ ] Obtener por ID
  - [ ] Actualizar cargas
  - [ ] Eliminar  
  - [ ] Obtener el viaje de la carga
  - [ ] Listar cargas

- [✔️] Trucks:
  - [✔️] Crear  
  - [✔️] Listar
  - [✔️] Obtener por ID
  - [✔️] Actualizar camion
  - [✔️] Eliminar camion
    
- [✔️] Drivers:
  - [✔️] Crear  
  - [✔️] Listar  
  - [✔️] Obtener por ID
  - [✔️] Actualizar driver
  - [✔️] Eliminar driver 
  
---

## ⚙️ 5. Lógica de negocio (CRÍTICO)
- [ ] No se puede agregar load sin travel  
- [ ] No se puede exceder capacidad del truck  
- [ ] Travel debe tener truck y driver asignados  
- [ ] Cálculo de peso total correcto  
- [ ] Validaciones de datos (nulls, valores negativos, etc.)  

---

## ❗ 6. Manejo de errores
- [✔️] Travel no encontrado → error claro  
- [ ] Truck capacity exceeded → error claro  
- [ ] Driver no disponible → error claro  
- [✔️] Respuestas consistentes (status + mensaje)  

---

## 🔄 7. Flujo completo probado (MUY IMPORTANTE)
- [✔️] Crear truck  
- [✔️] Crear driver  
- [✔️] Crear route  
- [ ] Crear travel  
- [ ] Agregar loads  
- [ ] Intentar romper reglas (y ver errores)  
- [ ] Consultar resultados  

---

## 🧪 8. Pruebas manuales mínimas
- [ ] Casos normales funcionan  
- [ ] Casos inválidos fallan correctamente  
- [ ] No hay errores inesperados (500)  

---

## 🧼 9. Código limpio
- [✔️] No hay lógica en controllers  
- [✔️] Métodos claros (`addLoad`, `assignTruck`, etc.)  
- [ ] Sin código duplicado  
- [✔️] Nombres entendibles  

---

## 🚀 10. Ready for Frontend (FINAL)
- [✔️] Puedes usar la API sin problemas desde Postman  
- [ ] Sabes exactamente qué endpoint usar para cada acción  
- [✔️] Las respuestas son claras y consistentes  
