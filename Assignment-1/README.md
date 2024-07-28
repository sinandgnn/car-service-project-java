# Araç Kiralama Sistemi

## Çalıştırma

```
javac Controller.java
java Controller <carsFile> <customersFile> <inputFile>
```

## Kullanım

cars.txt: Araç verileri

customers.txt: Müşteri verileri

input.txt: Girdiler

## Dosya formatları

### cars.txt:

type,brand,model,segment,transmissionType,trunkCapacity,color,age,fuelType,dailyRentalRate

```
Sedan,Toyota,Camry,D,Automatic,500,Black,2,Petrol,800
Hatchback,Volkswagen,Golf,C,Manual,400,White,3,Diesel,600
SUV,Jeep,Wrangler,E,Automatic,600,Red,1,Petrol,1000
```
### customers.txt

type,name,phoneNumber,identity/taxNumber

```
Individual,Hande Yurt,05312345678,01234567890
Company,Global Solutions,02345678901,654321098
```

### input.txt
#### Komutlar:

```
SHOW_AVAILABLE_CARS <CUSTOMER_TYPE>: Mevcut araçları gösterir.
SHOW_RENTED_CARS: Kiralanmış araçları gösterir.
SHOW_CUSTOMER_RENTALS <CUSTOMER_NAME>: Müşterinin mevcut kiralamalarını gösterir.
RENT_CAR <CUSTOMER_NAME> <CAR_TYPE> <RENTAL_PERIOD>: Araç kiralar.
CANCEL_RENTAL <CUSTOMER_NAME> <CAR_TYPE>: Kiralamayı iptal eder.
SHOW_CAR_DETAILS <CAR_TYPE> <BRAND> <MODEL>: Araç detaylarını gösterir.
```
