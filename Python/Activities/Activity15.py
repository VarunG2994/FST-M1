import pandas as pa

data = {
    "Name": ["Ram", "Lakshmana", "Shathrugna", "Bharatha"],
    "Age": ["25", "22", "20", "18"],
    "Office": ["IBM","Accenture","SAP","Alchemy"]
}

db = pa.DataFrame(data)

print(db)
