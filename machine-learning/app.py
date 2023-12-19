from flask import Flask, request, jsonify
import pandas as pd
import numpy as np
from module_tujuan import load_model

app = Flask(__name__)

# Load your machine learning model
model = load_model()

# Column names should match the ones used for training the model
column_names = ['teknik_1', 'teknik_2', 'teknik_3', 'teknik_4', 'teknik_5', 'teknik_6', 'teknik_7', 'teknik_8',
                'teknik_9', 'teknik_10', 'sosial_1', 'sosial_2', 'sosial_3', 'sosial_4', 'sosial_5', 'sosial_6',
                'sosial_7', 'sosial_8', 'sosial_9', 'sosial_10', 'mipa_1', 'mipa_2', 'mipa_3', 'mipa_4', 'mipa_5',
                'mipa_6', 'mipa_7', 'mipa_8', 'mipa_9', 'mipa_10', 'feb_1', 'feb_2', 'feb_3', 'feb_4', 'feb_5',
                'feb_6', 'feb_7', 'feb_8', 'feb_9', 'feb_10', 'sastra_1', 'sastra_2', 'sastra_3', 'sastra_4',
                'sastra_5', 'sastra_6', 'sastra_7', 'sastra_8', 'sastra_9', 'sastra_10', 'pendidikan_1',
                'pendidikan_2', 'pendidikan_3', 'pendidikan_4', 'pendidikan_5', 'pendidikan_6', 'pendidikan_7',
                'pendidikan_8', 'pendidikan_9', 'pendidikan_10', 'kesehatan_1', 'kesehatan_2', 'kesehatan_3',
                'kesehatan_4', 'kesehatan_5', 'kesehatan_6', 'kesehatan_7', 'kesehatan_8', 'kesehatan_9',
                'kesehatan_10']

@app.route('/predict', methods=['POST'])
def predict():
    try:
        # Get data from the mobile app
        json_data = request.get_json()
        jawaban_user = [json_data.get(col, 3) for col in column_names]

        # Transform input data for prediction
        new_data = pd.DataFrame([jawaban_user], columns=column_names)

        # Prediction
        prediction = model.predict(new_data)
        predicted_class = np.argmax(prediction)

        # Get class label from the predicted index
        labels = ['Ekonomi dan Bisnis', 'Kesehatan', 'MIPA', 'Pendidikan', 'Sastra dan Budaya', 'Sosial', 'Teknik']  # Replace with your class labels
        predicted_interest = labels[predicted_class]

        # Send the prediction result as a JSON response
        response = {'predicted_interest': predicted_interest}
        return jsonify(response)

    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    app.run(host='127.0.0.1', port=5000, debug=True)
