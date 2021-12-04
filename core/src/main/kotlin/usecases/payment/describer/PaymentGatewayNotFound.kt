package app.usecases.payment.describer

import app.errors.UseCaseError

class PaymentGatewayNotFound : UseCaseError(message = "Não foi possível encontrar um Gatway de Pagamento com este nome")