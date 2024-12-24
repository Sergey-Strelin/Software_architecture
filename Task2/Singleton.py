import gc
from time import sleep


class Connection:
    _connect = None
    _name_connect = ''

    # создаём соединение и контролируем, что оно единственное
    def __new__(cls, *args, **kwargs):
        if cls._connect is None:
            cls._connect = super().__new__(cls)

        return cls._connect

    # инициализируем соединение и если без названия - называем
    def __init__(self, name_connect):
        if self._name_connect == '':
            self._name_connect = name_connect
            print(f'Создано новое соединение с именем {self._name_connect}')
        else:
            print(f'Соединение установлено ранее. Используем имеющееся - {self._name_connect}')

    # сведения о имени соединения
    def __str__(self):
        return f'имя соединения - {self._name_connect}'


if __name__ == '__main__':
    # создаём первое соединение
    connection1 = Connection('соединение 1')

    # создаём второе соединение
    connection2 = Connection('соединение 2')

    # проверяем, что в обоих случаях используется одно и тоже соединение
    print(f'Первое соединение: {connection1},  ID соединения - {id(connection1)}')
    print(f'Второе соединение: {connection2},  ID соединения - {id(connection2)}')
