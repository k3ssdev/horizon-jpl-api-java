import sys
import requests

def process_file(file_name):
    try:
        with open(file_name) as file:
            # Realizar la solicitud POST
            url = 'https://ssd.jpl.nasa.gov/api/horizons_file.api'
            r = requests.post(url, data={'format': 'json'}, files={'input': file})

            # Guardar la respuesta en un archivo
            with open('results.txt', 'w') as output_file:
                output_file.write(r.text)

            print("Resultado guardado en results.txt")

    except FileNotFoundError:
        print("El archivo no existe.")
    except IOError:
        print("Error al leer o escribir en el archivo.")

if __name__ == "__main__":
    default_file = "query_parameters.txt"  # Nombre de archivo predeterminado

    if len(sys.argv) > 1:
        file_name = sys.argv[1]
    else:
        file_name = default_file

    process_file(file_name)
