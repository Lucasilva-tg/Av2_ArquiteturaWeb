Esta API RESTful utiliza JWT para autenticação e autorização, diferenciando os acessos de administradores, gerentes de produtos, vendedores e clientes. Cada tipo de usuário tem permissão para acessar endpoints específicos para gerenciar usuários, produtos, pedidos e visualizar o catálogo de produtos.

Estrutura do Projeto 

O projeto consiste em:

![1](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/813b7d29-2750-4ae4-bd90-4def0a7c6c3f)

A minha classe aplication fica responsavel por escaneia os componentes e dar ponto de entrada no aplicativo.

![2](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/cc248e43-7202-407b-b6eb-06048acc670f)

Minha classe config fica responsavel por configurar a segurança do app e define 3 usuarios em memoria.

![3](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/ef3d388c-afe0-4e2d-8e93-1b448a573933)

![4](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/47e92163-efd6-4491-9d39-76231866e223)

Minha classe controller ela fica responsavel em definir as end points.

![5](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/1562bac3-2e15-48d9-8db9-2389580093f2)

A minha classe security gera tokens JWT.
![image](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/bf2507f5-7a03-4ac4-a3ff-ba045d59fc89)

A minha classe service fornece serviços para gerar tokens JWT.
![7](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/b0835220-cc5d-4a99-933f-eb1c30ec2007)


Diagrama
![figma](https://github.com/Lucasilva-tg/Av2_ArquiteturaWeb/assets/101115192/e875143e-f8f4-4f2f-ae8a-9c1a2c587dae)
