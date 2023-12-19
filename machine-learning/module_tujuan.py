import tensorflow as tf

def load_model():
    model = tf.keras.models.load_model('tujuan.h5')  # Adjust the filename if needed
    return model
